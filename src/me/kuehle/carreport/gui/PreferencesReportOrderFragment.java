package me.kuehle.carreport.gui;

import java.util.List;

import me.kuehle.carreport.Preferences;
import me.kuehle.carreport.R;
import me.kuehle.carreport.data.report.AbstractReport;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.mobeta.android.dslv.DragSortListView;

public class PreferencesReportOrderFragment extends ListFragment {
	private class ReportDropListener implements DragSortListView.DropListener {
		@Override
		public void drop(int from, int to) {
			String item = adapter.getItem(from);
			adapter.remove(item);
			adapter.insert(item, to);
			adapter.notifyDataSetChanged();

			Preferences prefs = new Preferences(getActivity());
			reportClasses.add(to, reportClasses.remove(from));
			prefs.setReportOrder(reportClasses);
		}
	}

	private ArrayAdapter<String> adapter;
	private List<Class<? extends AbstractReport>> reportClasses;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_prefs_report_order,
				container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		DragSortListView lv = (DragSortListView) getListView();
		lv.setDropListener(new ReportDropListener());

		adapter = new ArrayAdapter<String>(getActivity(),
				R.layout.list_item_drag, android.R.id.text1);

		Preferences prefs = new Preferences(getActivity());
		reportClasses = prefs.getReportOrder();
		for (Class<? extends AbstractReport> reportClass : reportClasses) {
			AbstractReport report = AbstractReport.newInstance(reportClass,
					getActivity());
			adapter.add(report.getTitle());
		}
		
		setListAdapter(adapter);
	}
}
