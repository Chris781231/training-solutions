package statemachine.seatheater;

public enum SeatHeaterState {
    OFF {
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.THREE;
        }
    },
    THREE {
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.TWO;
        }
    },
    TWO {
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.ONE;
        }
    },
    ONE {
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.OFF;
        }
    };


    abstract SeatHeaterState next();
}
