public class OdunUretimEvi extends UretimBinasi{
	public OdunUretimEvi() {
		eklenecekDeger=5;
	}
	public boolean 	isProducible(int odun,Oyuncu player){
		if(odun>=10) {
			player.odun-=10;
			return true;
		}
		return false;
	}	
}
