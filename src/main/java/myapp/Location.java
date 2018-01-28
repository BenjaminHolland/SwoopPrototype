package myapp;
import java.util.UUID;

public class Location{
    public UUID id;
    public Double lat;
    public Double lon;
    public String name;
    public Integer price;
    public Integer rating;
    public Location(Double lat,Double lon,String name,Integer price,Integer rating){
        this.id=UUID.randomUUID();
        this.lat=lat;
        this.lon=lon;
        this.price=price;
        this.name=name;
        this.rating=rating;
    }
    public Location(){

    }
    @java.lang.Override
    public java.lang.String toString() {
        return "{" +
                "\"id\": \"" +id.toString()+"\""+
                "\"lat\":" + lat +
                ",\"lng\":" + -lon +
                ",\"name\":\"" + name +"\""+
                ",\"price\":" + price +
                ",\"rating\":" + rating +
                '}';
    }
}

