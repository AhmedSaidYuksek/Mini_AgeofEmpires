public class Kale  extends SavunmaBinasi {		
	public Kale() {
		can=100;
		vurus=150;
	}	
	public boolean isErectable(int altin,int odun,int tas) {
		if(altin>=5&&odun>=15&&tas>=40) {
			altin-=5;
			odun-=15;
			tas-=40;
			return true;
		}return false;
	}
}
