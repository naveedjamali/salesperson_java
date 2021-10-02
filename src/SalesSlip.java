public class SalesSlip {
    public int getSalesPersonID() {
        return _salesPersonID;
    }

    public void setPerson(int salesPersonID) {
        this._salesPersonID = salesPersonID;
    }

    public int getProductID() {
        return _productId;
    }

    public void setProductId(int productId) {
        this._productId = productId;
    }

    public double getSalesValue() {
        return _salesValue;
    }

    public void setSalesValue(double salesValue) {
        this._salesValue = salesValue;
    }

    private int _salesPersonID;
    private int _productId;
    private double _salesValue;

    public String toString(){
        return "PersonID: "+ _salesPersonID +", ProductID: "+ _productId +", Sales Amount: $"+ _salesValue +"/";
    }
}
