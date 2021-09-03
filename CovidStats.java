/*
Author - Bhanu Prathap Reddy Nallapreddy
Student ID - L30064720
Week 1  - Assignment - Observer patterns
 */

class CovidData
{
    int cases, vaccinated, deaths;
    int population = 500000; //sample population
    CovidCasesDisplay covidCasesDisplay;
    CovidStatsDisplay covidStatsDisplay;

    // Constructor
    public CovidData(CovidCasesDisplay covidCasesDisplay,
                     CovidStatsDisplay covidStatsDisplay)
    {
        this.covidCasesDisplay = covidCasesDisplay;
        this.covidStatsDisplay = covidStatsDisplay;
    }
// initiating with sample numbers for cases, vaccinations and deaths
    private int getCasesCount()
    {
        return 100000;
    }

    private int getVaccinatedCount()
    {
        return 1000;
    }

    private int getDeathCount()
    {
        return 500;
    }

    // update the stats
    public void updateData()
    {
        // get latest data
        cases = getCasesCount();
        vaccinated = getVaccinatedCount();
        deaths = getDeathCount();

        covidCasesDisplay.update(cases,vaccinated,deaths);
        covidStatsDisplay.update(cases,vaccinated,deaths, population);
    }
}


class CovidCasesDisplay
{
    private int cases, vaccinated, deaths;

    public void update(int cases,int vaccinated,int deaths)
    {
        this.cases = cases;
        this.vaccinated = vaccinated;
        this.deaths = deaths;
        display();
    }

    public void display()
    {
        System.out.println("\nCovid-19 Data: \n" +
                "Active Cases: " + cases +
                "\nVaccinated Count:" + vaccinated +
                "\nDeaths: " + deaths );
    }
}

class CovidStatsDisplay
{
    private float mortalityRate, infectionRate, vaccinatedRate ;

    public void update(int cases, int vaccinated, int deaths, int population)
    {
        this.mortalityRate = (float) deaths/cases;
        this.infectionRate = (float)cases/population;
        this.vaccinatedRate = (float) vaccinated/population;
        display();
    }

    public void display()
    {
        System.out.println("\nCovid-19 Stats:\n" +
                "Mortality Rate: " + mortalityRate +
                "\nInfection Rate: " + infectionRate +
                "\nVaccination Rate:" + vaccinatedRate);
    }
}


class CovidStats
{
    public static void main(String[] args)
    {
        CovidStatsDisplay covidStatsDisplay =
                new CovidStatsDisplay();
        CovidCasesDisplay covidCasesDisplay =
                new CovidCasesDisplay();

        CovidData covidData = new CovidData(covidCasesDisplay,
                covidStatsDisplay);

        covidData.updateData();
    }
}
