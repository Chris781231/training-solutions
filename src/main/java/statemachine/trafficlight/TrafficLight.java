package statemachine.trafficlight;

public enum TrafficLight {

    RED {
        @Override
        TrafficLight next() {
            return TrafficLight.RED_YELLOW;
        }
    },
    RED_YELLOW {
        @Override
        TrafficLight next() {
            return TrafficLight.GREEN;
        }
    },
    GREEN {
        @Override
        TrafficLight next() {
            return TrafficLight.YELLOW;
        }
    },
    YELLOW {
        @Override
        TrafficLight next() {
            return TrafficLight.RED;
        }
    };

    abstract TrafficLight next();
}
