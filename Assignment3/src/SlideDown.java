public class SlideDown {
    public void slide(Shape[][] J){

        for(int i=J.length-1;i>=0;i--){
            int count=0;

            while(count <10){
                for(int k=J.length-1;k>0;k--){

                    if(J[k][i].getType().equals("0")){
                        Shape j=J[k-1][i];
                        J[k-1][i]=J[k][i];
                        J[k][i]=j;


                    }

                }
                count ++;
            }


        }

    }
}
