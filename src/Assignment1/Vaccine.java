package Assignment1;

/**
 * Assignment I part II A
 * © Haochen Zou
 * Written by Haochen Zou 40158179
 */
public class Vaccine
{
    public enum Brand {pfizer, moderna, johnson, others, unknown};
    private Brand vaccineBrand;
    private double vaccineDose;
    private String expiryDate;
    private long vaccineId;
    private double priceTag;

    //count the number of Vaccine Objects
    private static int count = 0;

    //default constructor
    Vaccine()
    {
        vaccineBrand = Brand.unknown;
        vaccineDose = 0;
        expiryDate = null;
        vaccineId = 0;
        priceTag = 0;
    }

    //give vaccine id property
    Vaccine(long vaccineId)
    {
        vaccineBrand = Brand.unknown;
        vaccineDose = 0;
        expiryDate = null;
        this.vaccineId = vaccineId;
        vaccineId = 0;
        priceTag = 0;
    }

    Vaccine(Brand vaccineBrand, double vaccineDose, String expiryDate, long vaccineId, double priceTag)
    {
        this.vaccineBrand = vaccineBrand;
        this.vaccineDose = vaccineDose;
        this.expiryDate = expiryDate;
        this.vaccineId = vaccineId;
        this.priceTag = priceTag;
    }

    //count for vaccine number
    {
        count++;
    }

    //vaccine brand accessor and mutator
    public void setBrand(Brand vaccineBrand)
    {
        this.vaccineBrand = vaccineBrand;
    }

    public Brand getBrand()
    {
        return vaccineBrand;
    }

    //vaccine does accessor and mutator
    public void setVaccineDose(double vaccineDose)
    {
        this.vaccineDose = vaccineDose;
    }

    public double getVaccineDose()
    {
        return vaccineDose;
    }

    //vaccine expiry date accessor and mutator
    public void setExpiryDate(String expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate()
    {
        return expiryDate;
    }

    //vaccine Id accessor, no mutator because cannot change
    public long getVaccineId()
    {
        return vaccineId;
    }

    //vaccine price accessor and mutator
    public void setPriceTag(double priceTag)
    {
        this.priceTag = priceTag;
    }

    public double getPriceTag()
    {
        return priceTag;
    }

    //display information
    public String toString()
    {
        return "\nVaccine information:" +
                "\nVaccine Brand:\t\t\t" + vaccineBrand +
                "\nVaccine Dose:\t\t\t" + vaccineDose +
                "\nVaccine Expire Date:\t" + expiryDate +
                "\nVaccine ID:\t\t\t\t" + vaccineId +
                "\nVaccine Price Tag:\t\t"+priceTag;
    }

    //return the number of vaccine
    public static int findNumberOfCreatedVaccines()
    {
        return count;
    }

    //compare two vaccine for equality
    public boolean equals(Object object)
    {
        if(object == null)
        {
            return false;
        }
        else if(getClass() != object.getClass())
        {
            return false;
        }
        else
        {
            Vaccine vaccine = (Vaccine)object;
            return (vaccineBrand.equals(vaccine.vaccineBrand) && vaccineDose == vaccine.vaccineDose);
        }
    }
}
