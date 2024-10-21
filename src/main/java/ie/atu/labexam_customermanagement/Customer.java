package ie.atu.labexam_customermanagement;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String customerId;
    @NotBlank(message = "first name must not be empty")
    private String firstName;
    @NotBlank(message = "last name cannot be blank")
    private String lastName;
    @NotBlank(message = "email cannot be blank")
    private String email;
    @Digits(value = 10, message = "phone number must be 10 digits")
    private long phoneNumber;
    @PastOrPresent(message =  "Cannot be a future date")
    private String dateOfBirth;
    @Pattern(regexp = "A123456")
    private String eirCode;


}
