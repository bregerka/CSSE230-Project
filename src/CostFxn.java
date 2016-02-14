
public class CostFxn<T extends Comparable<? super T>> {

	double timeCost,distanceCost,dangerCost;
	int MOVEMENTPACE = 8;
	int BASEDISTANCE = 1000;
	
	public CostFxn(double straightDist,double danger){
		this.dangerCost = danger;
		this.distanceCost = distanceCalc(straightDist);
		this.timeCost = timeCalc(straightDist);		
	}
	
	private double timeCalc(double straightDist) {
		//Assuming movement pace of 8 m/s
		return (this.distanceCost/MOVEMENTPACE)/(60*60); //after return must Math.floor(value) to 
														 //grab values after the decimal and mult
														 //mult by 60 to get to mins
	}
	private double distanceCalc(double straightDist) {
		return straightDist + BASEDISTANCE*this.dangerCost;
	}
}
