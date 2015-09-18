package _05_WorkingWithWebTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * @summary Demonstrate methods to navigate through, and extract data from,
 *          table cells
 */
@SuppressWarnings("unused")
public class _01_WebTables {
	// Define a WebDriver
	WebDriver driver;
	// Define an element to hold each web table
	private WebElement tblWebTable;
	// Define an array of table IDs
	String[] strTableIds = { "table1", "table2" };
	// Define a String that will hold the text of each cell
	private String tableRowText;

	// Define an element to hold the table header
	private WebElement eleTableHeader;
	// Define an element to hold the table header row
	private WebElement eleTableHeaderRow;
	// Define an element to hold the table header cells
	List<WebElement> eleTableHeaderCells;
	private int intNumberOfHeaderColumns;

	// Define an element to hold the table body
	private WebElement eleTableBody;
	// Define a list of WebElements to hold the table body rows
	List<WebElement> eleTableBodyRows;
	// Define an integer to hold the number of table body rows
	private int intNumberOfTableBodyRows;
	// Define a list of WebElements to hold the cells for each table body row
	List<WebElement> eleTableBodyCellsPerRow;
	// Define an integer to hold the number of cells for each table body row
	private int intNumberOfTableBodyCellsPerRow;

	/**
	 * @summary Define fields and elements the interact with table elements,
	 *          create a WebDriver, navigate to a web page, use the driver to
	 *          locate and interact with each web table cell, then close the
	 *          browser and end the web driver session
	 */
	@Test
	public void _01_outputTextOfAllCells() {
		// Create a WebDriver
		driver = new FirefoxDriver();
		// Navigate to a specific table with web tables
		driver.get("http://the-internet.herokuapp.com/tables");
		// Maximixe the browser
		driver.manage().window().maximize();
		// Initialize the elements
		PageFactory.initElements(driver, this);

		// Iterate through each table
		for (String id : strTableIds) {
			System.out.println("**********************************************");
			System.out.println("**********************************************");
			// Grab the next web table
			tblWebTable = driver.findElement(By.id(id));
			// Grab the web table header
			eleTableHeader = tblWebTable.findElement(By.tagName("thead"));
			// Grab the web table header row
			eleTableHeaderRow = eleTableHeader.findElement(By.tagName("tr"));
			// Grab all cells in the web tbale header
			eleTableHeaderCells = eleTableHeaderRow.findElements(By.tagName("th"));
			// Determine the number of column headers
			intNumberOfHeaderColumns = eleTableHeaderCells.size();
			// Blank-out the string of table-row text
			tableRowText = "";
			// Iterate through each header and accumulate the header texts
			for (WebElement element : eleTableHeaderCells) {
				tableRowText = tableRowText + element.getText() + ";\t";
			}
			// Output the header text
			System.out.println(tableRowText + "\n");
			// Blank-out the string of table-row text
			tableRowText = "";

			// Grab the web table body
			eleTableBody = tblWebTable.findElement(By.tagName("tbody"));
			// Grab the web table body rows
			eleTableBodyRows = eleTableBody.findElements(By.tagName("tr"));
			// Grab the number of web table body rows
			intNumberOfTableBodyRows = eleTableBodyRows.size();
			// Iterate through each row in the web table body
			for (WebElement row : eleTableBodyRows) {
				// Grab the cells for each web table body row
				eleTableBodyCellsPerRow = row.findElements(By.tagName("td"));
				// Grab the number of cells for each web table body row
				intNumberOfTableBodyCellsPerRow = eleTableBodyCellsPerRow.size();
				// Iterate through each cell and accumulate the cell texts
				for (WebElement cell : eleTableBodyCellsPerRow) {
					tableRowText = tableRowText + cell.getText() + ";\t";
				}
				// Output the cell text for each row
				System.out.println(tableRowText + "\n");
				// Blank-out the string of table-row text
				tableRowText = "";
			}
		}
		System.out.println("**********************************************");
		System.out.println("**********************************************");
	}

	/**
	 * Iterate through each row and each cell per row and determine if a cell
	 * has a given text. If so, output the row and column that contains the text
	 */
	@Test(dependsOnMethods = "_01_outputTextOfAllCells")
	public void _02_findCells() {
		System.out.println("\n\n**********************************************");
		System.out.println("**********************************************");
		// Define a value that is used to determine if the text is found
		boolean textFound = false;
		// Define a list of strings for which to search the table
		String[] texts = { "fbach@yahoo.com", "http://www.timconway.com", "yabba dabba do" };
		// Define the table with which to work
		tblWebTable = driver.findElement(By.id("table1"));
		// Define the web table body
		eleTableBody = tblWebTable.findElement(By.tagName("tbody"));
		// Define counters row the rows and columns and initialize them
		int rowCounter = 0;
		int cellCounter = 0;
		// Iterate through the list of text for which to search
		for (String text : texts) {
			// Grab all of the rows for the web table
			eleTableBodyRows = eleTableBody.findElements(By.tagName("tr"));
			// Iterate through all rows in the web table
			for (WebElement row : eleTableBodyRows) {
				// Increment the row counter
				rowCounter++;
				// Grab all cells in each web table row
				eleTableBodyCellsPerRow = row.findElements(By.tagName("td"));
				// Iterate through each web table row cell
				for (WebElement cell : eleTableBodyCellsPerRow) {
					// Increment the cell counter
					cellCounter++;
					// Determine whether the cell has the desired text
					if (cell.getText().trim().equalsIgnoreCase(text)) {
						// If the text is found, output the current row and
						// column
						System.out.println("The text [" + text + "] was contained in row [" + String.valueOf(rowCounter)
								+ "] and column [" + String.valueOf(cellCounter) + "].");
						textFound = true;
					}
				}
				// Reset the cell counter
				cellCounter = 0;
			}
			// Reset the row counter
			rowCounter = 0;
			// If the text was not found, output to the console this fact;
			// otherwise, reset the boolean value
			if (!textFound) {
				System.out.println("The text [" + text + "] was not found in the webtable.");
			} else {
				textFound = false;
			}
		}

		driver.close();
		driver.quit();

		System.out.println("**********************************************");
		System.out.println("**********************************************\n\n");
	}
}
