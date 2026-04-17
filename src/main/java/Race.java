import java.util.ArrayList;
import java.util.List;

public class Race
{
    private final List<Car> leaders = new ArrayList<>();
    private int maxDistance = -1;

    public void addCarLead(Car car)
    {
        int distance = car.getDistanceFor24Hours();

        if (leaders.isEmpty() || distance > maxDistance)
        {
            leaders.clear();
            leaders.add(car);
            maxDistance = distance;
        }
        else if (distance == maxDistance)
        {
            leaders.add(car);
        }
    }

    public List<Car> getLeaders()
    {
        return leaders;
    }
}