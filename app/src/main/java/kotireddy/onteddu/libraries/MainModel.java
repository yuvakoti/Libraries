package kotireddy.onteddu.libraries;

import java.util.Arrays;

public class MainModel {

    DataModel[] dataModels;

    public DataModel[] getDataModels() {
        return dataModels;
    }

    public void setDataModels(DataModel[] dataModels) {
        this.dataModels = dataModels;
    }

    @Override
    public String toString() {
        return "MainModel{" +
                "dataModels=" + Arrays.toString(dataModels) +
                '}';
    }
}
