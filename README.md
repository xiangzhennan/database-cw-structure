## basic structure for database assignment
> This structure I build is a demonstration of my way to do this CW. (My actual work is slightly different but use the same idea).
### 1. quick start
> the project works similar to the guidance workbook.
> 1. start the server
> 2. start the client
> 3. type "select" in the client and submit by press enter
> 4. type "create" in the client and submit by press enter
> 5. type something else
### 2. data flow and key class
#### 2.1 data flow
> 1. command(String) passed into method parseAndRun()
> 2. instance created with reference type(Sql)
> 3. instance run its own implementation of methods parse() and run()
> 4. in run(), instance of IOUtil communicates with actual file
#### 2.2 key class
> please read every single line of comments in key classes
> 1. SqlFactory
> 2. Sql(abstract class)
> 3. IOEngine
### 3. donate if you find it useful, comment if you find it bull-shit
<img src="./img_1.png" alt ="" style="zoom: 67%;" />
<img src="./img_2.png" alt ="" style="zoom: 33%;" />
