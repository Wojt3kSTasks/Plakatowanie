package plakatowanie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Plakatowanie {

    public static void main(String[] args) {
        Plakatowanie plakatowanie = new Plakatowanie();
        System.out.println(plakatowanie.calculateNumberOfBillboards(plakatowanie.loadData()));
    }

    public int[] loadData() {
        int numberOfBuildings;
        int[] buildingsHeights = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String line = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            numberOfBuildings = Integer.parseInt(stringTokenizer.nextToken());
            buildingsHeights = new int[numberOfBuildings];
            for (int i = 0; i < numberOfBuildings; ++i) {
                line = bufferedReader.readLine();
                stringTokenizer = new StringTokenizer(line);
                stringTokenizer.nextToken();
                buildingsHeights[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
        } catch (Exception e) {
        }
        return buildingsHeights;
    }

    public int calculateNumberOfBillboards (int[] buildingsHeights) {
        int numberOfBillboards = 0;
        List<Integer> buildingsHeightsAvailable = new ArrayList<>();
        for (int i = 0; i < buildingsHeights.length; i++) {
            while(true){
                if (buildingsHeightsAvailable.size() == 0 || buildingsHeightsAvailable.get(buildingsHeightsAvailable.size() - 1) < buildingsHeights[i]) {
                    buildingsHeightsAvailable.add(buildingsHeights[i]);
                    break;
                } else if (buildingsHeightsAvailable.get(buildingsHeightsAvailable.size() - 1) == buildingsHeights[i]) {
                    break;
                } else {
                    numberOfBillboards++;
                    buildingsHeightsAvailable.remove(buildingsHeightsAvailable.size() - 1);
                }
            }
        }
        numberOfBillboards+= buildingsHeightsAvailable.size();
        return numberOfBillboards;
    }
}
