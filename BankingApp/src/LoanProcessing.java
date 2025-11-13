
public class LoanProcessing {
	
	int curr ;
	int limit;
	
	boolean getLoan(int amt) {
		if(curr+amt<=limit)return true;
		return false;
	}

}
