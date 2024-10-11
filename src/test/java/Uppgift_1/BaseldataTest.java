package Uppgift_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseldataTest {
    /**
     * Unit test of ProductionIdata class, to check if the getMainwork and GetDepartment methods return
     * the correct values.
     * Expected result: MainWork.Paper, "Production"
     */
    @Test
    public void testProductionIdata() {
        ProductionIdata productionIdataObj = new ProductionIdata();

        assertEquals(IIdata.MainWork.Paper, productionIdataObj.getMainwork());
        assertEquals("Production", productionIdataObj.GetDepartment());
    }

    /**
     * Unit test of DevIdata class, to check if the getMainwork and GetDepartment methods return
     * the correct values.
     * Expected result: MainWork.Digital, "Development"
     */
    @Test
    public void testDevIdata() {
        DevIdata devIdataObj = new DevIdata();

        assertEquals(IIdata.MainWork.Digital, devIdataObj.getMainwork());
        assertEquals("Development", devIdataObj.GetDepartment());
    }

}