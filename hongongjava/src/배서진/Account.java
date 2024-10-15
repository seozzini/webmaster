package 배서진;

public class Account {
	//필드
	private String ano;
	private String owner;
	private int balance;
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	
	//생성자
	Account(String ano, String owner, int balance){
		this.ano=ano;
		this.owner=owner;
		this.balance=balance;
	}
	
	//메소드
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		if(balance < Account.MIN_BALANCE) {
			this.balance = Account.MIN_BALANCE;
		}else if(balance>Account.MAX_BALANCE) {
			this.balance = Account.MAX_BALANCE;
		}else {
			this.balance = balance;
		}
		
	}
	
	void InMoney(String ano, int balance){
		this.ano = ano;
		this.balance = balance;		
	}
	
	
	
	 
}


	
	
	
	
