public class TasOcagi extends UretimBinasi{
	public TasOcagi() {
		eklenecekDeger=3;
	}
	public boolean 	isProducible(int odun,int tas,Oyuncu player){
		if(odun>=3&&tas>=10) {	
			player.odun-=3;
			player.tas-=10;
			return true;
		}
		return false;
	}	
}