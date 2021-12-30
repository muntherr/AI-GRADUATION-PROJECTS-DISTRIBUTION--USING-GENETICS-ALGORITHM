import java.util.ArrayList;
import java.io.*;
import java.util.Iterator;
import javax.swing.CellEditor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//THIS CLASS READS THE EXCEL FILE AND PRINTS ITS CONTENT INTO A SEMICOLON SEPERATED FILE "Student_Selections.txt"
public class GroupsPreferences {

	private int Groupnumbers = 0;
	private String Studentsname = null;
	private int Firstchoice = 0;
	private int Secondchoice = 0;
	private int Thirdchoice = 0;

	public GroupsPreferences(int groupnumbers, String studentsname, int firstchoice, int secondchoice,
			int thirdchoice) {
		super();
		this.Groupnumbers = groupnumbers;
		this.Studentsname = studentsname;
		this.Firstchoice = firstchoice;
		this.Secondchoice = secondchoice;
		this.Thirdchoice = thirdchoice;
	}

	static public ArrayList<GroupsPreferences> Groups;

	public int getGroupnumbers() {
		return Groupnumbers;
	}

	public void setGroupnumbers(int groupnumbers) {
		Groupnumbers = groupnumbers;
	}

	public String getStudentsname() {
		return Studentsname;
	}

	public void setStudentsname(String studentsname) {
		Studentsname = studentsname;
	}

	public int getFirstchoice() {
		return Firstchoice;
	}

	public void setFirstchoice(int firstchoice) {
		Firstchoice = firstchoice;
	}

	public int getSecondchoice() {
		return Secondchoice;
	}

	public void setSecondchoice(int secondchoice) {
		Secondchoice = secondchoice;
	}

	public int getThirdchoice() {
		return Thirdchoice;
	}

	public void setThirdchoice(int thirdchoice) {
		Thirdchoice = thirdchoice;
	}

	public static ArrayList<GroupsPreferences> getGroups() {
		return Groups;
	}

	public static void setGroups(ArrayList<GroupsPreferences> groups) {
		Groups = groups;
	}

	public static void printCourses() {
		try {

			// PrintWriter writer = new PrintWriter("courses.txt", "UTF-8");
			for (int i = 0; i < Groups.size(); i++)
				System.out.println(Groups.get(i).getGroupnumbers() + "," + Groups.get(i).getStudentsname() + ","
						+ Groups.get(i).getFirstchoice() + "," + Groups.get(i).getSecondchoice() + ","
						+ Groups.get(i).getThirdchoice());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void ConvertTocsv() throws IOException {
		// This class reads the groups data from the excel file and stores each groups
		// choices

		File excelFile = new File("Students+selections.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIt = sheet.iterator();

		File file = new File("Student_Selections.txt");
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);

		while (rowIt.hasNext()) {
			Row row = rowIt.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				// System.out.print(cell.toString() + ";");
				pw.print(cell.toString() + ";");
			}
			// System.out.println();
			pw.println();
		}
		workbook.close();
		fis.close();
		pw.close();
		ReadCSvfile();
	}

	// Read Converted CSV File and Add it to the Array list
	public static void ReadCSvfile() {
		int i = 1;
		GroupsPreferences.Groups = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("Student_Selections.txt"))) {
			String line = br.readLine();
			while (line != null) {
				if (line.contains("Groups;")) {
					line = br.readLine();
				} else {
					String[] Data = line.split(";");
					String Names = Data[0];
					int First = (int) Double.parseDouble(Data[1]);
					int Second = (int) Double.parseDouble(Data[2]);
					int Third = (int) Double.parseDouble(Data[3]);
					Groups.add(new GroupsPreferences(i, Names, First, Second, Third));
					i++;
					line = br.readLine();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
