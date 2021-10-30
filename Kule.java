public class Kule extends SavunmaBinasi {	
	public Kule() {
		can=50;
		vurus=50;
	}
	public boolean isErectable(int altin,int odun,int tas) {
		if(altin>=1&&odun>=5&&tas>=20) {
			altin-=1;
			odun-=5;
			tas-=20;
			return true;
		}return false;
	}
}
