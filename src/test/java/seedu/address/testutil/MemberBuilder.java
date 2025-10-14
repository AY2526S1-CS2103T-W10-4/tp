package test.java.seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.member.Address;
import seedu.address.model.member.Email;
import seedu.address.model.member.Name;
import seedu.address.model.member.Member;
import seedu.address.model.member.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Member objects.
 */
public class MemberBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Set<Tag> tags;

    /**
     * Creates a {@code MemberBuilder} with the default details.
     */
    public MemberBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
    }

    /**
     * Initializes the MemberBuilder with the data of {@code memberToCopy}.
     */
    public MemberBuilder(Member memberToCopy) {
        name = memberToCopy.getName();
        phone = memberToCopy.getPhone();
        email = memberToCopy.getEmail();
        address = memberToCopy.getAddress();
        tags = new HashSet<>(memberToCopy.getTags());
    }

    public MemberBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    public MemberBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    public MemberBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    public MemberBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    public MemberBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    public Member build() {
        return new Member(name, phone, email, address, tags);
    }

}
