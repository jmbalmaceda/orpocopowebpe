package com.criterya.utils;

import org.apache.log4j.Logger;
import java.util.Map;

/**
 * @author pantusap
 *
 */
public class EnvironmentUtil {
    //~ Static fields/initializers -----------------------------------------------------------------

    protected static final Logger logger = Logger.getLogger(EnvironmentUtil.class);

    //~ Constructors -------------------------------------------------------------------------------

    /**
     * Crea un nuevo objeto EnvironmentUtil.
     *
     * @param prefixPathName requerido.
     * @param prefixPathValue requerido.
     */
    public EnvironmentUtil(String prefixPathName, String prefixPathValue) {
        String valueProperty = System.getProperty(prefixPathName);
        String valueEnv = null;
        Map<String, String> env = System.getenv();
        if (env != null) {
            valueEnv = env.get(prefixPathName);
        }

        if ((valueProperty == null) && (valueEnv == null)) {
            System.setProperty(prefixPathName, prefixPathValue);
        }
    }
}