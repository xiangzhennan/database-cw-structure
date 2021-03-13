package statements;

/*
 * this is an example class demonstrating how polymorphism works
 * */
public class Select extends Sql{
	private String tableName;
	@Override
	public void parse(String command) {
		tableName = "demo";
		System.out.println("parse select, set table name demo");
	}

	@Override
	public void run() {
		super.getIoEngine().readFile(tableName);
	}
}
