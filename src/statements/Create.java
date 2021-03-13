package statements;

/*
* this is an example class demonstrating how polymorphism works
* */
public class Create extends Sql{
	private String tableName;
	@Override
	public void parse(String command) {
		tableName = "demo";
		System.out.println("parse create, set table name demo");
	}

	@Override
	public void run() {
		super.getIoEngine().writeFile(tableName);
	}
}
