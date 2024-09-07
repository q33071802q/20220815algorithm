package design.strategy;

public class NavigatorTest{
    public static void main(String[] args) {
        Navigator navigator = new Navigator();
        navigator.buildRoute("A","B");
        navigator.setRouteStrategy(new PublicTransportStrategy());
        navigator.buildRoute("A","B");
    }
}

class Navigator {
    public Navigator() {
        this.routeStrategy = new RoadStrategy();
    }

    RouteStrategy routeStrategy;
    void buildRoute(String A,String B){
        routeStrategy.buildRoute(A,B);
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }
}

interface RouteStrategy{
    void buildRoute(String A,String B);
}

class RoadStrategy implements RouteStrategy{
    @Override
    public void buildRoute(String A, String B) {
        System.out.println("RoadStrategy");
    }
}
class PublicTransportStrategy implements RouteStrategy{
    @Override
    public void buildRoute(String A, String B) {
        System.out.println("PublicTransportStrategy");
    }
}
class WalkingStrategy implements RouteStrategy{
    @Override
    public void buildRoute(String A, String B) {
        System.out.println("WalkingStrategy");
    }
}


