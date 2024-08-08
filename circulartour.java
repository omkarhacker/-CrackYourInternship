class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	// Your code here	
	    int n=petrol.length;
	    int start=0;
	    int pre=0;
	    int total=0;
	    for(int i=0;i<n;i++){
	        total=total+petrol[i]-distance[i];
	        if(total<0){
	            pre=pre+total;
	            total=0;
                start=i+1;
	        }
	    }
	    if(pre<0 && (-1*pre)>total){
	        return -1;
	    }
	    return start;
    }
    
}