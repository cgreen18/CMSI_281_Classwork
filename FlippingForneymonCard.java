public class FlippingForneymonCard extends ForneymonCard implements MinForneymonCard{

    boolean isDown;

    FlippingForneymonCard(String nameArg, String typeArg,boolean initialArg){
        super(nameArg,typeArg);
        isDown = initialArg;
    }

    FlippingForneymonCard(){
        super();
        isDown = true;
    }

    public boolean flip(){
        isDown = !isDown;
        return isDown;
    }

    public int match(FlippingForneymonCard forneyArg){
        if(forneyArg.getStatus() || getStatus()){
            return 2;
        }
        else if( (forneyArg.getName().equals(this.getName())) && (forneyArg.getType().equals(this.getType())) ){
            return 1;
        }
        else{
            return 0;
        }
    }

    public boolean getStatus(){
        return isDown;
    }

    public String toString(){
        if(isDown){
            return ("?:?");
        }
        else{
            return super.toString();
        }

    }
}
