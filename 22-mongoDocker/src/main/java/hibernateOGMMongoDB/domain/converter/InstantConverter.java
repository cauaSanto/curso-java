package hibernateOGMMongoDB.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.time.Instant;

@Convert
public class InstantConverter implements AttributeConverter<Instant, String> {

    @Override
    public String convertToDatabaseColumn(Instant attribute) {
        return attribute.toString();
    }

    @Override
    public Instant convertToEntityAttribute(String dbData) {
        return Instant.parse(dbData);
    }

}