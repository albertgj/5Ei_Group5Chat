package it.group3.groupchat.usertotuser.client;

import it.group3.groupchat.usertotuser.implementation.UserToUserPack;
import java.io.IOException;

/**
 *
 * @author Gjergjaj Albert
 */
public class Main 
{
    public static void main(String[] args) throws IOException
    {
        UserToUserPack test = new UserToUserPack();
        test.sendMsgToUser("s nec elementum ornare, felis ligula aliquet quam, a porta magna dui sit amet odio. Aliquam vel velit id ante sollicitudin vehicula non quis orci. Vivamus consequat posuere finibus. Nulla posuere eu purus pharetra ullamcorper. Nunc commodo urna eget nulla maximus, porta porta quam sagittis. Vestibulum vitae consectetur magna. Donec eu tortor non magna porta porta. Vivamus ornare turpis eu nisl bibendum, id luctus ante semper. Pellentesque pretium iaculis odio. Nunc eget purus eu lectus sodales condimentum ut id augue. Aenean et tortor suscipit, molestie mauris eu, placerat lectus.Nulla scelerisque diam facilisis vulputate sodales. In dapibus dolor leo, in finibus ligula tincidunt nec. Aliquam luctus convallis diam viverra tempus. Nulla id elementum velit. Fusce diam massa, porttitor ut vulputate quis, vulputate in sapien. Aliquam rutrum rutrum risus, ut elementum nunc molestie pulvinar. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce eget aliquet diam. Pellentesque vulputate aliquam nulla. In egestas molestie nulla, sed dignissim ipsum blandit vel. Ut sem odio, bibendum finibus hendrerit in, imperdiet nec lorem. Sed ut erat vitae augue sodales sagittis. Pellentesque eu scelerisque nisl, in ullamcorper lectus. Sed vitae aliquet quam. Nam ac purus purus Sed ut molestie est. Quisque quis augue id dui euismod viverra vitae sed mauris. Cras eu porttitor justo. Cras lorem dui, gravida in fringilla ut, scelerisque ac justo. Curabitur pharetra condimentum arcu id scelerisque. Cras eu semper ante. Nulla quis massa ac nisl hendrerit fermentum. Vivamus at malesuada dolor. Integer laoreet, leo et ornare eleifend, enim neque cursus quam, sed consectetur diam felis nec lacus. Integer eu commodo metus.", "id", "iddest"); 
        test.receiveMsgFromUser();
    }
}
