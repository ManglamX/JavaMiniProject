import java.util.*;

public class WasteManagementSystem {
    private List<Waste> wasteList;
    private List<CollectionSchedule> collectionSchedules;

    public WasteManagementSystem() {
        wasteList = new ArrayList<>();
        collectionSchedules = new ArrayList<>();
    }

    public void addWaste(String type, double weight) {
        wasteList.add(new Waste(type, weight));
        System.out.println("Waste added successfully!");
        suggestDisposalMethod(type);
        provideEducationalResources(type);
    }

    public void viewReport() {
        if (wasteList.isEmpty()) {
            System.out.println("No waste data available.");
            return;
        }
        
        System.out.println("Waste Report:");
        for (Waste waste : wasteList) {
            System.out.println(waste);
        }
    }

    public void calculateTotalWaste() {
        double totalWeight = 0;
        for (Waste waste : wasteList) {
            totalWeight += waste.getWeight();
        }
        System.out.println("Total Waste: " + totalWeight + " kg");
    }

    public void addCollectionSchedule(String wasteType, String date) {
        collectionSchedules.add(new CollectionSchedule(wasteType, date));
        System.out.println("Collection schedule added for " + wasteType + " on " + date);
    }

    public void viewCollectionSchedules() {
        if (collectionSchedules.isEmpty()) {
            System.out.println("No collection schedules available.");
            return;
        }
        
        System.out.println("Collection Schedules:");
        for (CollectionSchedule schedule : collectionSchedules) {
            System.out.println(schedule);
        }
    }

    private void suggestDisposalMethod(String type) {
        String method = "";
        switch (type.toLowerCase()) {
            case "plastic":
                method = "\nRecycle at designated recycling centers.";
                break;
            case "paper":
                method = "\nRecycle or composting.";
                break;
            case "organic":
                method = "\nComposting or use municipal organic waste collection.";
                break;
            case "glass":
                method = "\nRecycle at designated recycling centers.";
                break;
            case "metal":
                method = "\nRecycle at designated recycling centers.";
                break;
            case "hazardous":
                method = "\nContact local hazardous waste disposal services.";
                break;
            default:
                method = "\nCheck local guidelines for proper disposal.";
                break;
        }
        System.out.println("Suggested disposal method for " + type + ": " + method);
    }

    private void provideEducationalResources(String type) {
        String resources = "";
        switch (type.toLowerCase()) {
            case "plastic":
                resources = "Learn more about plastic recycling:\n[Plastic Recycling Guide](https://www.plasticsrecycling.org/)";
                break;
            case "paper":
                resources = "Learn more about paper recycling:\n[Paper Recycling Tips](https://www.recyclepaper.com/)";
                break;
            case "organic":
                resources = "Learn more about composting:\n[Composting Basics](https://www.epa.gov/recycle/composting-home)";
                break;
            case "glass":
                resources = "Learn more about glass recycling:\n[Glass Recycling Information](https://www.glassrecycling.org/)";
                break;
            case "metal":
                resources = "Learn more about metal recycling:\n[Metal Recycling Guide](https://www.recyclemetal.com/)";
                break;
            case "hazardous":
                resources = "Learn more about hazardous waste disposal:\n[Hazardous Waste Disposal](https://www.epa.gov/hw/what-hazardous-waste)";
                break;
            default:
                resources = "General waste reduction tips:\n[Waste Reduction Tips](https://www.epa.gov/recycle/reducing-waste)";
                break;
        }
        System.out.println("Educational resources for " + type + ": " + resources);
    }

    public static void main(String[] args) {
        WasteManagementSystem system = new WasteManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWaste Management System");
            System.out.println("1. Add Waste");
            System.out.println("2. View Report");
            System.out.println("3. Calculate Total Waste");
            System.out .println("4. Add Collection Schedule");
            System.out.println("5. View Collection Schedules");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter waste type\n(Ex- plastic,paper,organic,glass,metal,hazardious etc. :");
                    String type = scanner.nextLine();
                    System.out.print("Enter weight (kg): ");
                    double weight = scanner.nextDouble();
                    system.addWaste(type, weight);
                    break;
                case 2:
                    system.viewReport();
                    break;
                case 3:
                    system.calculateTotalWaste();
                    break;
                case 4:
                    System.out.print("Enter waste type for collection schedule: ");
                    String scheduleType = scanner.nextLine();
                    System.out.print("Enter collection date (DD/MM/YY): ");
                    String scheduleDate = scanner.nextLine();
                    system.addCollectionSchedule(scheduleType, scheduleDate);
                    break;
                case 5:
                    system.viewCollectionSchedules();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

class Waste {
    private String type;
    private double weight;

    public Waste(String type , double weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Waste Type: " + type + ", Weight: " + weight + " kg";
    }
}

class CollectionSchedule {
    private String wasteType;
    private String date;

    public CollectionSchedule(String wasteType, String date) {
        this.wasteType = wasteType;
        this.date = date;
    }

    public String getWasteType() {
        return wasteType;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Collection Schedule for " + wasteType + " on " + date;
    }
}