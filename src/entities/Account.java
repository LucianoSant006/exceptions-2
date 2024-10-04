package entities;
import exceptions.BusinessException;
public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder,  Double withdrawLimit,Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }



    public void deposit (Double amount){

        balance += amount;

    }
    public void withLimit(Double amount) throws BusinessException {
        withVerificLimit(amount);
        balance -= amount ;
    }
    public void withVerificLimit(double amount ) throws BusinessException {

        if( amount > withdrawLimit){
            throw new BusinessException("Withdraw Error: the amount exceeds withdraw Limit ");
        }
        if(amount > getBalance()){

            throw new BusinessException("Withdraw Error: Not enough balance");
        }

    }
    @Override
    public String toString(){

        return "New balance: "+String.format("%.2f",getBalance());
    }






}
