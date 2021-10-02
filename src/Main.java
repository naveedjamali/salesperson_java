import javax.sound.midi.SysexMessage;
import java.util.Random;

public class Main {
    /**
     * Assumed sales slips for a month.
     * 4 sales person. each passing 5 slips per day, for 30 days.
     * 600 slips are generated per month. each one containing personID, productID, and sales value.
     */
    static SalesSlip[][] slips = new SalesSlip[120][5];

    public static void main(String[] args) {
        /**
         * load one month fake data in the slips
         */
        loadSales();

        /**
         * Sales summary for 4 persons and 5 products.
         */

        int[][] summary = new int[4][5];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                SalesSlip slip = slips[i][j];

                summary[slip.getSalesPersonID() - 1][slip.getProductID() - 1] += slip.getSalesValue();
            }
        }
        /**
         * Print total sales summary
         */

        /**
         * print header
         */
        System.out.println("\n\n\nSalerID\tProd-1\tProd-2\tProd-3\tProd-4\tProd-5\tTotal");

        /**
         * Sum of all sales by 4 sales persons.
         */
        int totalOfAllSalePersons = 0;

        /**
         * Print 2D summary table
         */

        for (int i = 0; i < 4; i++) {
            System.out.print((i + 1) + "\t\t");
            int totalSalesByPerson = 0;
            for (int j = 0; j < 5; j++) {
                System.out.printf("%5d", summary[i][j]);
                System.out.print("\t");
                totalSalesByPerson += summary[i][j];

            }
            /**
             * Print total by single sales person.
             */
            System.out.println(totalSalesByPerson);
            /**
             * add single person's sale in all salespersons sale.
             */
            totalOfAllSalePersons += totalSalesByPerson;
        }


        System.out.print("total\t");
        /**
         * Summing up sales by product.
         */
        for (int i = 0; i < 5; i++) {

            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += summary[j][i];
            }
            /**
             * print each product's total sale.
             */
            System.out.printf("%5d", sum);
            System.out.print("\t");

        }

        /**
         * print all sales persons' total sale.
         */
        System.out.print(totalOfAllSalePersons);


    }

    /**
     * Function to create dummy sales for one month.
     */

    static void loadSales() {
        int salesPersonId = 1;
        for (int i = 1; i <= 120; i++) {

            for (int j = 1; j <= 5; j++) {
                SalesSlip slip = new SalesSlip();
                Random rand = new Random();

                slip.setProductId(j);
                slip.setPerson(salesPersonId);
                slip.setSalesValue(rand.nextInt(2000));

                slips[i - 1][j - 1] = slip;

            }

            if (salesPersonId == 4) {

                salesPersonId = 1;

            } else {

                salesPersonId++;
            }
        }
    }

}
