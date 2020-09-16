package Refl;


import java.math.BigDecimal;

public class ReflTest {

    @Scale(size = 2)
    private BigDecimal InsuranceAmount;

    @Scale(size = 0)
    private  BigDecimal InsurancePremium;

    public BigDecimal getInsuranceAmount(Integer scale) {
        InsuranceAmount=InsuranceAmount.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return InsuranceAmount;
    }

    public void setInsuranceAmount(BigDecimal insuranceAmount) {
        InsuranceAmount = insuranceAmount;
    }

    public BigDecimal getInsurancePremium(Integer scale) {
        InsurancePremium = InsurancePremium.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return InsurancePremium;
    }

    public void setInsurancePremium(BigDecimal insurancePremium) {
        InsurancePremium = insurancePremium;
    }
}
