package Model;

import java.util.ArrayList;

/**
 *This class has module grade and module name
 */
public class ModuleGrade {
    private int moduleGrade;
    private String moduleName;

    /**
     * Constructor passing parameters modulegrade and module name
     * @param ModuleGrade
     * @param moduleName
     */
    public  ModuleGrade(int ModuleGrade, String moduleName){
    this.moduleGrade = moduleGrade;
    this.moduleName = moduleName;

    }

    /**
     * gets module grade
     * @return
     */
    public int getModuleGrade() {
        return moduleGrade;
    }

    /**
     * sets module grade
     * @param moduleGrade
     */
    public void setModuleGrade(int moduleGrade) {
        this.moduleGrade = moduleGrade;
    }

    /**
     * gets module name
     * @return
     */

    public String getModuleName() {
        return moduleName;
    }

    /**
     * Sets module name
     * @param moduleName
     */

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
