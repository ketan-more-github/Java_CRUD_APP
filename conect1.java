package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class conect1 {
	
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getRoll_no() {
			return roll_no;
		}

		public void setRoll_no(int roll_no) {
			this.roll_no = roll_no;
		}

		public String getGender() {
			return Gender;
		}

		public void setGender(String gender) {
			Gender = gender;
		}

		public String getMobile_num() {
			return mobile_num;
		}

		public void setMobile_num(String mobile_num) {
			this.mobile_num = mobile_num;
		}

		String name;
		int roll_no;
		String Gender;
		String mobile_num;
		
		public conect1(String name, int roll_no, String gender, String mobile_num) {
			super();
			this.name = name;
			this.roll_no = roll_no;
			Gender = gender;
			this.mobile_num = mobile_num;
		}
		
	
		
	

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		
		System.out.println();
		System.out.println("______________welcome to student Management App ketan_____________________");
		System.out.println();
		
		
		//connection check 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school" , "ketan" , "1137");
			Scanner sc2 = new Scanner(System.in);				
		while(true)
		{

			System.out.println("____________________menue______________________");
			System.out.println();
			System.out.println("Enter 1 to insert Records");
			System.out.println("Enter 2 to Display record");
			System.out.println("Enter 3 to Delete record");
			System.out.println("Enter 4 to Update record");
			System.out.println("Enter 0 to Exite");
			System.out.println("_______________________________________________");
			System.out.println();
			
			int ch = sc2.nextInt();
			if(ch==1)
			{
				//***********************insert********************************
				
				System.out.println("Please Insert data");
				Scanner sc  = new Scanner(System.in);
				
				System.out.println("Enter Name");
				String name = sc.nextLine();
				
				System.out.println("Enter Roll_num");
				String S = sc.nextLine();
				int roll_num  = Integer.parseInt(S);
				System.out.println("Enter Gender");
				String Gender = sc.nextLine();
				
				System.out.println("Enter mobile number");
				String mobile_num = sc.nextLine();	
				conect1 s1 = new conect1(name, roll_num, Gender, mobile_num);
				
					PreparedStatement stmt=con.prepareStatement("insert into student values(?,? ,?,?)");  
					stmt.setString(1, s1.name);
					stmt.setInt(2, s1.roll_no);
					stmt.setString(3, s1.Gender);
					stmt.setString(4, s1.mobile_num);
					int i=stmt.executeUpdate();  
					System.out.println(i+" records inserted");
				
			}
			else if(ch==2)
			{
				//***********************Display********************************
				
				String s = "select * from student";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(s);
				System.out.println();
				System.out.printf("| %-15s | %-7s | %-6s | %-15s |%n" , "Name", "Roll_no", "Gender" , "mobile_no");
				System.out.println();
				
				while(rs.next())
				{
					//System.out.println(rs.getString(1)+ " " +rs.getInt(2) + " " + rs.getString(3)+" "+ rs.getString(4) );
					System.out.printf( "| %-15s | %-7s | %-6s | %-15s |%n" , rs.getString(1) , rs.getInt(2)  ,  rs.getString(3) ,  rs.getString(4));	
				}
				
				System.out.println();
				System.out.println();
				
			}
			else if(ch==3)
			{
				PreparedStatement ps2 = con.prepareStatement("delete from student where roll_no = ?");
				System.out.println("Enter roll to delete");
				Scanner sc = new Scanner(System.in);
				int id  = sc.nextInt();
				ps2.setInt(1, id);
				ps2.executeUpdate();
				System.out.println("Deletd succesfully");
				System.out.println();
				System.out.println();
				
			}
			else if(ch==4)
			{
				PreparedStatement ps3 = con.prepareStatement("update student set Name = ? , roll_no = ? , Gender = ? , mobile_no = ? where roll_no = ?");
				
				System.out.println("Enter roll_num which you want to update ");
				Scanner sc = new Scanner(System.in);
				String k  = sc.nextLine();
				int id = Integer.parseInt(k);
				
				System.out.println("Enter Name");
				String name = sc.nextLine();
				
				System.out.println("Enter Roll_num");
				String S = sc.nextLine();
				int roll_num  = Integer.parseInt(S);
				
				System.out.println("Enter Gender");
				String Gender = sc.nextLine();
				
				System.out.println("Enter mobile number");
				String mobile_num = sc.nextLine();
				
				ps3.setString(1, name);
				ps3.setLong(2, roll_num);
				ps3.setString(3, Gender);
				ps3.setString(4, mobile_num);
				ps3.setInt(5, id);
				ps3.executeUpdate();
				System.out.println("Update succesfully");
				System.out.println();
				System.out.println();
			}
			else if(ch==0)
			{
				break;
				
			}
			else
			{
				
			}
		
		}
		System.out.println("App closed ");	
		System.out.println("bye bye ketan");	
		con.close();
		sc2.close();
		
		
	}}
		
					
			
			
			
//			
			  
			
