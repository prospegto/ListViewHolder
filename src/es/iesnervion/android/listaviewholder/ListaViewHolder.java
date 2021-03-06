package es.iesnervion.android.listaviewholder;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListaViewHolder extends ListActivity {
  TextView selection;
  private static final String[] items={"lorem", "ipsum", "dolor",
          "sit", "amet",
          "consectetuer", "adipiscing", "elit", "morbi", "vel",
          "ligula", "vitae", "arcu", "aliquet", "mollis","alarma",
          "etiam", "vel", "erat", "placerat", "ante", "calendario",
          "porttitor", "sodales", "pellentesque", "GPS" ,"augue", "purus"};
  
  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.activity_lista_view_holder);
    setListAdapter(new IconicAdapter<String>(this, R.layout.row, R.id.label, items));
    selection=(TextView)findViewById(R.id.selection);
  }
  
  public void onListItemClick(ListView parent, View v,
                              int position, long id) {
    selection.setText(items[position]);
  }
  
  class IconicAdapter<T> extends ArrayAdapter<T> {
    IconicAdapter( Context c, int resourceId, int textId, T[] objects) {
      super(c, resourceId, textId, objects);
    }
    
    public View getView(int position, View convertView,
                        ViewGroup parent) {
      
      View row = convertView;
      ViewHolder holder;
      
      if (row==null){
    	  LayoutInflater inflater=getLayoutInflater();
    	  row=inflater.inflate(R.layout.row, parent, false);
    	  
    	  holder = new ViewHolder (row,R.id.label,R.id.icon);
    	  row.setTag(holder);
      }
      else{
    	  holder = (ViewHolder) row.getTag();
      }
      
      holder.getLab().setText(items[position]);
     
      if (items[position].equals("calendario")) {
        holder.getImg().setImageResource(R.drawable.calendar48x48);
      }
      else if (items[position].equals("GPS")){
    	  holder.getImg().setImageResource(R.drawable.compass48x48);
      }
      else if (items[position].equals("alarma")){
    	  holder.getImg().setImageResource(R.drawable.alarm48x48);
      }
      else{
    	  holder.getImg().setImageResource(R.drawable.delete);
      }
      
      return(row);
    }
  }
  
  class ViewHolder {
	  TextView lab;
	  ImageView img;
	  	  
	  ViewHolder (View row, int labId, int imgId){
		  this.lab = (TextView) row.findViewById(labId);
		  this.img = (ImageView) row.findViewById(imgId); 
	  }
	  
	  public TextView getLab (){
		  return this.lab;
	  }
	  
	  public ImageView getImg (){
		  return this.img;
	  }
  }
}