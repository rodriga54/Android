package edu.niu.z1758468.implicitintent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {


    private Button browserBtn, phoneBtn, picBtn;
    private ImageView picImage;

    static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browserBtn = (Button)findViewById(R.id.webBrowserBtn);
        phoneBtn = (Button)findViewById(R.id.dialerBtn);
        picBtn = (Button)findViewById(R.id.pictureButton);
        picImage = (ImageView)findViewById(R.id.picImageView);

    }// End

    public void goBrowser (View view)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.espn.go.com"));
        startActivity(browserIntent);
    }
    public void goPhone (View view)
    {
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+8152225555") );
        startActivity(phoneIntent);
    }
    public void goPicture(View view)
    {
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (pictureIntent.resolveActivity(getPackageManager())!= null)
        {
            startActivityForResult(pictureIntent, REQUEST_CODE);
        }
    }// end of goPicture

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && requestCode == RESULT_OK)
        {
            Bundle bundle = data.getExtras();
            Bitmap image = (Bitmap)bundle.get("data");
            picImage.setImageBitmap(image);
        }
    }// End of onActivityResult
}
