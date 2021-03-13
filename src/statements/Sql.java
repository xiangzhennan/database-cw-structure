package statements;

import IOUtil.IOEngine;

/*
* we are dealing with 9 type of sql statement
* but there are things that is common
* 	1.sql statements needs to record info, such as the name of table to manipulate
* 	2.sql statements should be able to parse a command(String)
* 	3.sql statements should be able to do something to DB or tables
* that is why we need this sql abstract parent class
* */
public abstract class Sql {
	/*
	* ioEngine is a class that specifically deal with file IO
	* so any method related to file IO should be inside it
	* */
	private IOEngine ioEngine = new IOEngine();

	public IOEngine getIoEngine() {
		return ioEngine;
	}

	public abstract void parse(String command);

	public abstract void run();

}
