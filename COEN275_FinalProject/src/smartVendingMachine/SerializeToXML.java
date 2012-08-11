package smartVendingMachine;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SerializeToXML {

	public void serializeObjectToXML(String xmlFileLocation,
			Object objectToSerialize) throws FileNotFoundException {

		if (xmlFileLocation == "") {
			throw new FileNotFoundException();
		}

		FileOutputStream fOStream = new FileOutputStream(xmlFileLocation);
		XMLEncoder encoder = new XMLEncoder(fOStream);
		encoder.writeObject(objectToSerialize);
		encoder.close();
}

	public Object deserializeXMLToObject(String xmlFileLocation)
			throws FileNotFoundException {

		if (xmlFileLocation == "") {
			throw new FileNotFoundException();
		}

		FileInputStream fIStream = new FileInputStream(xmlFileLocation);
		XMLDecoder decoder = new XMLDecoder(fIStream);
		Object deserializedObject = decoder.readObject();
		decoder.close();

		return deserializedObject;
	}

}
