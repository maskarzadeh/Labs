// MultimodalTrafficViolationSystem.java - Complex Multimodal Input Design Pattern

import java.util.ArrayList;
import java.util.List;




// Abstract Class for Input
abstract class Input {
    public abstract String preprocess();
}

// Image Input Class
class Image_From_Intersection_Input extends Input {
    @Override
    public String preprocess() {
        return "Processed Intersection Footage (Image)";
    }
}

// Numerical Input Class
class Numerical_Time_of_Day_Input extends Input {
    @Override
    public String preprocess() {
        return "Processed Time of Day (Numerical)";
    }
}

// Categorical Input Class
class Categorical_Weather_Condition_Input extends Input {
    @Override
    public String preprocess() {
        return "Processed Weather Condition (Categorical)";
    }
}

// Combined Input Class
class CombinedInput {
    public String combineInputs(List<String> inputs) {
        StringBuilder combined = new StringBuilder();
        for (String input : inputs) {
            combined.append(input).append(" | ");
        }
        combined.setLength(combined.length() - 3); // Remove trailing " | "
        return combined.toString();
    }
}

// ML Model Class
class MLModel {
    public String trainModel(String combinedInput) {
        return "Training model with combined input: " + combinedInput;
    }

    public String predict(String combinedInput) {
        return "Prediction: No Traffic Violation detected for input: " + combinedInput;
    }
}

// Prediction Class
class Prediction {
    private final MLModel model;

    public Prediction(MLModel model) {
        this.model = model;
    }

    public void train(String combinedInput) {
        System.out.println(model.trainModel(combinedInput));
    }

    public void predict(String combinedInput) {
        System.out.println(model.predict(combinedInput));
    }
}

// Main Class
public class  MultimodalTrafficViolationSystem {
    public static void main(String[] args) {
        // Step 1: Create inputs
        Input imageInput = new Image_From_Intersection_Input();
        Input numericalInput = new Numerical_Time_of_Day_Input();
        Input categoricalInput = new Categorical_Weather_Condition_Input();

        // Step 2: Preprocess inputs
        List<String> processedInputs = new ArrayList<>();
        processedInputs.add(imageInput.preprocess());
        processedInputs.add(numericalInput.preprocess());
        processedInputs.add(categoricalInput.preprocess());

        // Step 3: Combine inputs
        CombinedInput combinedInput = new CombinedInput();
        String combinedData = combinedInput.combineInputs(processedInputs);

        // Step 4: Train model
        MLModel model = new MLModel();
        Prediction prediction = new Prediction(model);

        System.out.println("=== Training Phase ===");
        prediction.train(combinedData);

        // Step 5: Make prediction
        System.out.println("=== Prediction Phase ===");
        prediction.predict(combinedData);
    }
}
