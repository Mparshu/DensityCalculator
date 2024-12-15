package com.example.density_calculator;


public class DensityCalculator {
    /**
     * Calculate foam density
     * @param weight Weight in grams
     * @param length Length in mm
     * @param width Width in mm
     * @param thickness Thickness in mm
     * @return Density in kg/m³
     */
    public static double calculateDensity(double weight, double length, double width, double thickness) {
        // Calculate volume in mm³
        double volumeMm3 = length * width * thickness;

        // Convert volume to cm³ (1 cm³ = 1000 mm³)
        double volumeCm3 = volumeMm3 / 1000.0;

        // Calculate density in g/cm³
        double densityGramPerCm3 = weight / volumeCm3;

        // Convert to kg/m³ (multiply by 1000)
        double densityKgPerM3 = densityGramPerCm3 * 1000.0;

        return densityKgPerM3;
    }

    /**
     * Format density result to two decimal places
     * @param density Density in kg/m³
     * @return Formatted density string
     */
    public static String formatDensity(double density) {
        return String.format("The density of the foam is %.1f kg/m³", density);
    }
}
