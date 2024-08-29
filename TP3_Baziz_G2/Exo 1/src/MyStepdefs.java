import com.exception.NoSquareException;
import com.model.Matrix;
import com.service.MatrixMathematics;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.util.List;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;


public class MyStepdefs {
    double[][] tab = new double[3][3];
    Matrix Matrice = new Matrix(tab);

    double resultat;
    @Given("I have a matrix")
    public void iHaveAMatrix(DataTable datatable) {
        List<List<Double>> rows = datatable.asLists(Double.class);
        int i =0;

        for (List<Double> columns : rows) {
            tab[i][0] = columns.get(0);
            tab[i][1] = columns.get(1);
            tab[i][2] = columns.get(2);
            i++;
        }
    }

    @When("I compute the determinant")
    public void iComputeTheDeterminant() throws NoSquareException {
         MatrixMathematics Mat = new MatrixMathematics();
         resultat = Mat.determinant(Matrice);
    }

    @Then("I should have {double}")
    public void iShouldHave(double result) {
        assertEquals( resultat,result);
    }
}


