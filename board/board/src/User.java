
public class User {
	private String username;
	private String password;
	private int category;
	//gia na ksexwrizei o aplos user apo ton admin gia ton admin to category einai 1 kai gia ton user 2
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
		//1=admin
		//2=user
	}

	public int checkUserType(String username, String password){
		//elegxos orthothtas stoixeiwn othonhs eisodou
		//1=admin-swsto username kai pass
		//2=admin-swsto username lathos pass
		//3=user-swsto username kai pass
		//4=user-swsto username lathos pass
		//5=username pou den yparxei
		if (username.equals("admin")){
			if(password.equals("admin1")){
				User currentUser=new User(username, password);
				currentUser.setCategory(1);
				System.out.println("You are admin");
				return 1;
			}
			else{
				System.out.println("Wrong Password");
				return 2;
			}
		}
		//else if(username.equals("user")){
			//if(password.equals("user1")){
			//	User currentUser=new User(username, password);
				//currentUser.setCategory(2);
				//System.out.println("You are user");
				//return 3;
			//}
			//else{
			//	System.out.println("Wrong Password");
			//	return 4;
			//}
		//}
		else{
			System.out.println("Wrong Username");
			return 3;
		}
	}
	/*an h klash ginei serializable wste o paixths na apothikeyei thn proswpikh tou proodo ta username kai
	password apothikeyontai se ksexwristo binary arxeio kai o elegxos ston user allazei wste na elegxetai kathe
	fora an uparxei ayto to username sthn lista kai an uparxei an antistoixei sto password pou plhktrologeitai
	*/
}
