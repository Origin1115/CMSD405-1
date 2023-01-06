/*
 * File Name: TransformAdjustment.java
 * Name: David Crawley
 * Date: 1/06/2023
 */
@SuppressWarnings("WeakerAccess")
public class TransformAdjustment {
    private int translateX;
    private int translateY;
    private double rotation;
    private double scaleX;
    private double scaleY;

    public TransformAdjustment(int translateX, int translateY, double rotation, double scaleX, double scaleY){
        this.translateX = translateX;
        this.translateY = translateY;
        this.rotation = rotation;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    public double getRotation() {
        return rotation;
    }

    public double getScaleX() {
        return scaleX;
    }

    public double getScaleY() {
        return scaleY;
    }

    public int getTranslateX() {
        return translateX;
    }

    public int getTranslateY() {
        return translateY;
    }

    public TransformAdjustment getAdjustment(TransformAdjustment requestedTransform){

        int tx = this.translateX;
        int ty = this.translateY;
        double r = this.rotation;
        double sx = this.scaleX ;
        double sy = this.scaleY ;

        if(requestedTransform != null) {
            tx = requestedTransform.translateX != 0 ? tx + requestedTransform.translateX : tx;
            ty = requestedTransform.translateY != 0 ? ty + requestedTransform.translateY : ty;
            r = requestedTransform.rotation != 0 ? r + requestedTransform.rotation : r;
            sx = requestedTransform.scaleX > 0 ? requestedTransform.scaleX : sx;
            sy = requestedTransform.scaleY > 0 ? requestedTransform.scaleY : sy;
        }

        return new TransformAdjustment(tx, ty, r, sx, sy);
    }

    public TransformAdjustment clone(){
        return new TransformAdjustment(this.translateX, this.translateY,
                this.rotation, this.scaleX, this.scaleY);
    }
}
