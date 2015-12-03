package barqsoft.footballscores.appWidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;

import java.util.ArrayList;

import barqsoft.footballscores.R;


public class ListProvider implements RemoteViewsFactory {
	private ArrayList<ListItem> listItemList = new ArrayList<ListItem>();
	private Context context = null;
	private int appWidgetId;



//	private List<Task> taskList = new ArrayList<Task>();
	private String[] fragmentdate = new String[1];
	private Cursor cursor;


	public ListProvider(Context context, Intent intent) {
		this.context = context;
		appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);

		populateListItem();
	}

	private void populateListItem() {
		for (int i = 0; i < 10; i++) {
			ListItem listItem = new ListItem();
			listItem.heading = "Heading" + i;
			listItem.content = i + " This is the content of the app widget listview";
			listItemList.add(listItem);
		}

	}

	@Override
	public int getCount() {
		return listItemList.size();
	}

	@Override
	public long getItemId(int position) {
		return position;
	}


	@Override
	public RemoteViews getViewAt(int position) {
		final RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.list_row);
		ListItem listItem = listItemList.get(position);
		remoteView.setTextViewText(R.id.heading, listItem.heading);
		remoteView.setTextViewText(R.id.content, listItem.content);

		return remoteView;
	}
	

	@Override
	public RemoteViews getLoadingView() {
		return null;
	}

	@Override
	public int getViewTypeCount() {
		return 1;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public void onCreate() {

//		cursor = new CursorLoader(context, DatabaseContract.scores_table.buildScoreWithDate(), null, null, fragmentdate, null);
//		taskList = TaskService.getTaskInStateList(context, context.getResources().getString(R.string.DB_STATE_ACTIVE));
//		taskList.addAll(TaskService.getTaskInStateList(context, context.getResources().getString(R.string.DB_STATE_IN_RANGE)));
//		taskList.addAll(TaskService.getTaskInStateList(context, context.getResources().getString(R.string.DB_STATE_DELAYED)));

	}


	@Override
	public void onDataSetChanged() {
	}

	@Override
	public void onDestroy() {
	}

}
