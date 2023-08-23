package groupe1.webshop.application.jpa.entity;

public class JsonFormatPojo {
    
    public String propertyPath;
    
    public String invalidValue;
    
    public String message;

    public String getPropertyPath() {
        return propertyPath;
    }

    /**
     * @param propertyPath
     */
    public void setPropertyPath(String propertyPath) {
        this.propertyPath = propertyPath;
    }

    /**
     * @return
     */
    public String getInvalidValue() {
        return invalidValue;
    }

    /**
     * @param invalidValue
     */
    public void setInvalidValue(String invalidValue) {
        this.invalidValue = invalidValue;
    }

    /**
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }    

}