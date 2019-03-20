package com.java.collection.assessment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.collection.assessment.Employee;

@SuppressWarnings("unchecked")
public class EmployeeManage {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 final String DB_URL = "jdbc:mysql://localhost/EmployeeManagement_db";
	 final String USER = "root";
	 final String PASS = "";

	 Connection conn = null;
	  Statement stmt=null;
	
	static Scanner sc=new Scanner(System.in);
	static int key;
	TreeMap<Integer,Employee> empObj=new TreeMap<>();
	
	/* public void showEmp() {
		 System.out.println("\t Emp ID \t Emp Name \t Emp salary \t Emp Dept \t Emp DOB \t Emp Age");
		 if(key==0) {
			 System.out.println("No data available");
		 }
		 else {
		 
		for(Object emp:empObj.keySet()) {
			//System.out.println(empObj.get(emp));
			System.out.format("\t    %s \t      %s \t      %d \t      %s \t        %s  \t        %d",empObj.get(emp).eid,empObj.get(emp).name,empObj.get(emp).salary,empObj.get(emp).dept,empObj.get(emp).dob.toString(),getEmpAge(empObj.get(emp).dob));
			System.out.println("\n");
		}
		 }
	 }
	 
	 public void displayAll(Collection<Map.Entry<Integer, Object>> col) {
			Iterator<Map.Entry<Integer, Object>> itr = col.iterator();
			while (itr.hasNext()) {
				Map.Entry<Integer, Object> entry = itr.next();
				System.out.println(entry.getKey() + " " + entry.getValue() + " ");
				
			}
			System.out.println();
	}
	 
	
	
	public void addEmployee() throws CustomException {
		// TODO Auto-generated method stub
		System.out.println("enter employee ID: ");
		String eid=sc.next();
		
		System.out.println("enter employee name: ");
		String name=sc.next();
		
		System.out.println("enter employee salary: ");
		int salary=sc.nextInt();
		while(true) {
			try {
				throw new CustomException(salary); 
				
			}
			catch(CustomException ex) {
				//System.out.println(ex.getMessage());
				if(CustomException.sl==0)
					break;
				System.out.println("enter employee salary: ");
				salary=sc.nextInt();
			}
		}
		
		System.out.println("enter employee DOB: ");
		String inputdob=sc.next();
		LocalDate dob = LocalDate.parse(inputdob);
		
		        

		
		System.out.println("enter employee depertment: ");
		String dept=sc.next();
		
		empObj.put(++key, new Employee<Number>(eid,name,salary,dob,dept));
		System.out.println("Employee successfully added");
	}
	
	

	public void editEmployee() {
		System.out.println("Enter key value to Update :");
		int editKey=sc.nextInt();
		
		System.out.println("Editable record : "+empObj.get(editKey));
		
		while(true) {
			System.out.println("\n 1. edit name \n 2. edit salary \n 3. exit");
			int editType=sc.nextInt();
			
			switch(editType) {
			case 1:
				System.out.println("Enter updated name : ");
				String updatedName=sc.next();
				Collection<Employee> values=empObj.values();
				for(Employee emp:values) {
					emp.setName(editKey, updatedName);
				}
				System.out.println("Employee successfully updated");
				break;
				
			case 2:
				System.out.println("Enter updated salary : ");
				int updatedSalary=sc.nextInt();
				Collection<Employee> values1=empObj.values();
				for(Employee emp:values1) {
					emp.setSalary(editKey, updatedSalary);
				}
				System.out.println("Employee successfully updated");
				break;
				
			case 3:
				return;
			}
			
		}
	}
	
	public void deleteEmployee() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter key value :");
		int delKey=sc.nextInt();
		int len=empObj.size();
		if(delKey>len || delKey<1) {
			System.out.println("Record does not exist !!!");
		}
		else {
			System.out.println("deleted emp : "+ empObj.remove(delKey));
		}
 
	}
	public void searchEmployee() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("\n 1. search by key \n 2. search by Employee ID \n 3. search by Employee Name \n 4. Exit ");
			int searchType=sc.nextInt();
			
			switch(searchType) {
			case 1:
				System.out.println("----- Search by Key Value -----");
				System.out.println("Enter key value : ");
				int searchKey=sc.nextInt();
				int len=empObj.size();
				if(searchKey>len || searchKey<1) {
					System.out.println("Record does not exist !!!");
				}
				else {
					System.out.println(empObj.get(searchKey));
				}
				break;
			
			case 2:
				System.out.println("----- Search by Employee ID -----");
				System.out.println("Enter Employee ID : ");
				String searchId=sc.next();
				Collection<Employee> values1 = empObj.values();
				for(Employee emp : values1) {
					if(emp.getEid().compareToIgnoreCase(searchId) == 0) {
						System.out.println(emp);
					}
					else {
						System.out.println("Data not Found");
					}
				}
				System.out.println();
				break;
				
			case 3:
				System.out.println("----- Search by Employee Name -----");
				System.out.println("Enter Employee name : ");
				String searchName=sc.next();
				Collection<Employee> values = empObj.values();
				for(Employee emp : values) {
					if(emp.getName().compareToIgnoreCase(searchName) == 0) {
						System.out.println(emp);
					}
					else {
						System.out.println("Data not Found");
					}
				}
				System.out.println();
				break;
				
			case 4:
				return;
				
			default:
				System.out.println("Please press currect option");
			}
			
			
	}
	
	}
	
	public void employeeStatistic() {
		// TODO Auto-generated method stub
		System.out.println("----- Employee Statistics ----");
		
		Collection<Employee> values=empObj.values();
		
		//List<Integer> ages = Arrays.asList(empObj.get(emp));
		
		//total salary
		double totalSalary=values.stream()
								.map(Employee::getSalary)//stream of salary
								.reduce(0, (a,b)-> a.intValue()+b.intValue())
								.doubleValue(); //sum of salary
								
								//Identity-> Initial value or default
								//Accumulator-> 
		 System.out.println("Total salary of all employee : "+totalSalary);
		 
		 
		 //average salary
		 double avgSalary=values.stream()
				 				//.map(Employee::getSalary)
				 				.collect(Collectors.averagingDouble(Employee::getSalary))
				 				.doubleValue(); 
				 				
		System.out.println("Average salary of all employee : "+ avgSalary);	 	
		
		
		//deptwise employee count and sorting
		Map<String,Long> groupByDept=values.stream()
																.sorted(Comparator.comparing(Employee::getDept))
																.collect(Collectors.groupingBy(Employee::getDept,TreeMap::new,Collectors.counting()));
																
		System.out.println("dept wise employee count with sorted order : " + groupByDept);
		
		
		//deptwise avg age
//		Map<Object, Double> avgAgeGroupByDept=values.stream()
//													.collect(Collectors.groupingBy(Employee::getDept,Collectors.averagingInt(Employee::getAge)));
//		
//		System.out.println("Deptwise Avg Age : " + avgAgeGroupByDept);
//		
		
		//department have more than 3 emp
		List<String> deptHasGT3emp=values.stream()
											.collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()))
											.entrySet()
											.stream()
											.filter(entry->entry.getValue()>3)
											.map(Map.Entry::getKey)
											.collect(Collectors.toList());

		System.out.println("Dept has more than 3 emp : " + deptHasGT3emp);
		
		//Emp name start with 's'
		List<String> matchedName=values.stream()
									.filter(s->s.getName().toLowerCase().startsWith("s".toLowerCase()))
									.map(Employee::getName) //using method reference
									.collect(Collectors.toList());
		
		System.out.println("Employee name start with 's' : "+ matchedName);
		
		//employee count age > 30
//		long counts = values.stream()
//							.filter(e->e.getAge()>30)
//							.count();
//		
//		System.out.println("No of employee age>30 : " + counts);
//		
		
		//list of emp  ID have age > 30
//		List<String> filteredEid = values.stream()
//											.filter(e->e.getEmpAge(empObj.get(e).dob)>30)
//											.map(e->e.getEid())
//											.collect(Collectors.toList());
//
//		System.out.println(" List of Employee ID for Age > 30 : " + filteredEid);
		
		
	}

	public void employeeExport() {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\BrajaGopalMaity\\Desktop\\employeeManagement.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			for(Object emp:empObj.keySet()) {
				out.writeObject(empObj.get(emp));
			}
			
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in C:\\Users\\BrajaGopalMaity\\Desktop\\employeeManagement.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
		
	}

	public void employeeImport() {
		// TODO Auto-generated method stub
		System.out.println("..... Deserialized Employee Records ....");
		System.out.println("\n");
		
		
		  Employee e = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("C:\\Users\\BrajaGopalMaity\\Desktop\\employeeManagement.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         for(Object emp:empObj.keySet()) {
		         e = (Employee) in.readObject();
		         
		          System.out.print("  Emp ID : " + e.eid);
			      System.out.print("  Name : " + e.name);
			      System.out.print("  Salary : " + e.salary);
			      System.out.print("  DOB : " + e.dob);
			      System.out.print("  Department : " + e.dept);
			      System.out.println("\n");
	         }
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	
	}

	public void importUsingThread() {
		// TODO Auto-generated method stub
		int count=0;
		try(Scanner in=new Scanner(new FileReader("C:\\Users\\BrajaGopalMaity\\Desktop\\employee-input.txt"))){
			while(in.hasNextLine()) {
				String emp=in.nextLine();
				Employee employee=new Employee();
				StringTokenizer tokenizer=new StringTokenizer(emp,",");
				System.out.println(tokenizer.nextToken());
				System.out.println(tokenizer.nextToken());
				System.out.println(tokenizer.nextToken());
				System.out.println(tokenizer.nextToken());
				System.out.println(tokenizer.nextToken());
				
//				String eid=tokenizer.nextToken();
//		 		String name=tokenizer.nextToken();
//				int salary=Integer.parseInt(tokenizer.nextToken());
//				LocalDate dob=LocalDate.parse(tokenizer.nextToken());
//				String dept=tokenizer.nextToken();
				
				//empObj.put(++key, new Employee(eid,name,salary,dob,dept));
				
				count++;
			}
			System.out.println(count+" employee import successfull");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/

	
	
	
	public int getEmpAge(LocalDate dob) {
		// TODO Auto-generated method stub
		LocalDate curDate = LocalDate.now();
		return Period.between(dob, curDate).getYears();
		
	}
	public void insertIntoDatabase() throws ClassNotFoundException{
		// TODO Auto-generated method stub
		try {
		System.out.println("enter employee ID: ");
		String eid=sc.next();
		
		System.out.println("enter employee name: ");
		String name=sc.next();
		
		System.out.println("enter employee salary: ");
		int salary=sc.nextInt();
//		while(true) {
//			try {
//				throw new CustomException(salary); 
//				
//			}
//			catch(CustomException ex) {
//				//System.out.println(ex.getMessage());
//				if(CustomException.sl==0)
//					break;
//				System.out.println("enter employee salary: ");
//				salary=sc.nextInt();
//			}
//		}
		
		System.out.println("enter employee DOB: ");
		String inputdob=sc.next();
		LocalDate dob = LocalDate.parse(inputdob);
		
		System.out.println("enter employee depertment: ");
		String dept=sc.next();
		
		
		 
			
		 //try {
			 //Statement stmt = null;
			 Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(DB_URL, USER, PASS);
			  stmt= conn.createStatement();
			 //if(conn!=null) {
			 String insertSql="insert into employee(eid,name,salary,dob,dept) values('"+eid+"','"+name+"',"+salary+",'"+dob+"','"+dept+"')";
			 int count=stmt.executeUpdate(insertSql);
			 //if(insertStatus) {
				 System.out.println("Employee successfully inserted");
			// }
			 
			 
			 try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }catch(SQLException se) {
			 System.out.println(se);
			 
		 }
		 finally {
			 try {
				 if(stmt!=null) {
					 stmt.close();
				 }
			 }
			 catch(SQLException e) {
				 e.printStackTrace();
			 }
			
			 try {
				 if(conn!=null) {
				conn.close();
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}

	public void showFromDatabase() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 Statement stmt = conn.createStatement();
			 if(conn!=null) {
				 String sql="select * from employee";
				 ResultSet rs = stmt.executeQuery(sql);
				 System.out.println("\t Emp ID \t Emp Name \t Emp salary \t Emp DOB \t Emp Dept  ");
				 
					 while(rs.next()) {
						 	System.out.format("\t    %s \t      %s \t      %d \t      %s \t        %s  ",rs.getString("eid"),rs.getString("name"),rs.getInt("salary"),rs.getDate("dob"),rs.getString("dept"));
							System.out.println("\n");
						
					}
				 
			 }
			 
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public void deleteFromDatabase() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter Emp ID for delete");
			String deleteEid=sc.next();
			
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 Statement stmt = conn.createStatement();
			 if(conn!=null) {
				 String sql="delete from employee where eid= '"+ deleteEid +"' ";
				 int statusCount=stmt.executeUpdate(sql);
				 System.out.println(statusCount+" Employee record successfully deleted");
			 }
			 else {
				 System.out.println("Connection is not established !!");
			 }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			 try {
				 if(stmt!=null) {
					 stmt.close();
				 }
			 }
			 catch(SQLException e) {
				 e.printStackTrace();
			 }
			
			 try {
				 if(conn!=null) {
				conn.close();
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
	}

	public void updateFromDatabase() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 Statement stmt = conn.createStatement();
			 
			System.out.println("Enter Employee ID to Update Record : ");
			String editEid=sc.next();
			
			if(conn!=null) {
				String sql1="select * from employee where eid='"+ editEid +"'";
				 ResultSet rs = stmt.executeQuery(sql1);
				 System.out.println("\t Emp ID \t Emp Name \t Emp salary \t Emp DOB \t Emp Dept  ");
				 System.out.println("Editable Record : ");
					 while(rs.next()) {
						 	System.out.format("\t    %s \t      %s \t      %d \t      %s \t        %s  ",rs.getString("eid"),rs.getString("name"),rs.getInt("salary"),rs.getDate("dob"),rs.getString("dept"));
							System.out.println("\n");
						
					}
					
				System.out.println("Please choose correct option ");
				while(true) {
					System.out.println("\n 1. edit name \n 2. edit salary \n 3. edit department \n 4. Exit");
					int editType=sc.nextInt();
					
					switch(editType) {
					case 1:
						System.out.println("Enter updated name : ");
						String updatedName=sc.next();
						if(conn!=null) {
							String sql2="update employee set name='"+ updatedName +"' where eid='"+ editEid +"'";
							 Boolean updateNameStatus = stmt.execute(sql2);
							 if(updateNameStatus==false) {
								 System.out.println("Name successfully updated");
							 }
						}else {
							System.out.println("Connection failed");
						}
						break;
						
					case 2:
						System.out.println("Enter updated salary : ");
						int updatedSalary=sc.nextInt();
						String sql3="update employee set salary="+ updatedSalary +" where eid='"+ editEid +"'";
						 Boolean updateSalaryStatus = stmt.execute(sql3);
						 if(!updateSalaryStatus) {
							 System.out.println("Salary successfully updated");
						 }
						break;
						
					case 3:
						System.out.println("Enter updated Department : ");
						String updatedDept=sc.next();
						String sql4="update employee set dept='"+ updatedDept +"' where eid='"+ editEid +"'";
						 Boolean updateDeptStatus = stmt.execute(sql4);
						 if(!updateDeptStatus) {
							 System.out.println("Department successfully updated");
						 }
						break;
						
					case 4:
						return;
					}
					
				}
			}
		}catch(SQLException e) {
			e.getStackTrace();
		}
		finally {
			 try {
				 if(stmt!=null) {
					 stmt.close();
				 }
			 }
			 catch(SQLException e) {
				 e.printStackTrace();
			 }
			
			 try {
				 if(conn!=null) {
				conn.close();
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}

	public void employeeStatisticsFromDatabase() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("----Employee Statistics---- ");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(DB_URL, USER, PASS);
			 Statement stmt = conn.createStatement();
			 
			 if(conn!=null) {
				 String sql="select * from employee where name like 'b%'";
				 ResultSet rs=stmt.executeQuery(sql);
				 System.out.println("Employee Details who's name Strt with 'b' : ");
				 System.out.println("\t Emp ID \t Emp Name \t Emp salary \t Emp DOB \t Emp Dept  ");
				 while(rs.next()) {
					 System.out.format("\t    %s \t      %s \t      %d \t      %s \t        %s  ",rs.getString("eid"),rs.getString("name"),rs.getInt("salary"),rs.getDate("dob"),rs.getString("dept"));
					 System.out.println("\n");
				 }
				 
				 System.out.print("Employee having salary > 20000 : ");
				 String sql2="select name from employee where salary>20000";
				 ResultSet rs2=stmt.executeQuery(sql2);
				 while(rs2.next()) {
					 System.out.println(rs2.getString("name"));
				 }
				 
				 //total salary
				 String sql3="select sum(salary) as total from employee";
				 ResultSet rs3=stmt.executeQuery(sql3);
				 while(rs3.next()) {
					 System.out.println("Total salary of all employee : "+rs3.getInt("total"));
				 }
				 
				//average salary
				 String sql4="select avg(salary) as averageSalary from employee";
				 ResultSet rs4=stmt.executeQuery(sql4);
				 while(rs4.next()) {
					 System.out.println("Average salary of all employee : "+rs4.getInt("averageSalary"));
				 }
				 
				 System.out.print("Department wise employee count with sorted order :  ");
				 String sql5="select dept,count(*) as empNo from employee group by dept order by dept";
				 ResultSet rs5=stmt.executeQuery(sql5);
				 while(rs5.next()) {
					 System.out.print(rs5.getString("dept")+" -> "+rs5.getInt("empNo")+" , ");
				 }
				 System.out.println("\n");
			 }else {
				 System.out.println("Connection not established");
			 }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			 try {
				 if(stmt!=null) {
					 stmt.close();
				 }
			 }
			 catch(SQLException e) {
				 e.printStackTrace();
			 }
			
			 try {
				 if(conn!=null) {
				conn.close();
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}
	

}
