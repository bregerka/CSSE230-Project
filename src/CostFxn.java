
public class CostFxn{

	double timeCost,distanceCost,dangerCost;
	int MOVEMENTPACE = 8;
	int BASEDISTANCE = 15;
	
	/**
	 * Stores the straight distance cost and danger cost
	 * @param straightDist
	 * @param danger
	 */
	public CostFxn(double straightDist,double danger){
		this.dangerCost = danger;
		this.distanceCost = distanceCalc(straightDist);
		this.timeCost = timeCalc(straightDist);
	}
	/**
	 * Calculates time to travel
	 * @param straightDist
	 * @return
	 */
	private double timeCalc(double straightDist) {
		//Assuming movement pace of 8 m/s
		return (this.distanceCost/MOVEMENTPACE)/(60*60); //after return must Math.floor(value) to 
														 //grab values after the decimal and mult
														 //mult by 60 to get to mins
	}
	/**
	 * Calculates the straight distance and danger cost added together
	 * @param straightDist
	 * @return
	 */
	private double distanceCalc(double straightDist) {
		return straightDist + BASEDISTANCE*this.dangerCost;
	}
	/**
	 * return the cost of the distance and danger
	 * @return distanceCost
	 */
	public int getDist(){
		return (int) this.distanceCost;
	}
}
