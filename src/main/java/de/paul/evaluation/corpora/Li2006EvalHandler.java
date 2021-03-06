package de.paul.evaluation.corpora;

import java.io.IOException;

import de.paul.util.Paths;

public class Li2006EvalHandler extends CorpusEvalHandler {

	protected static Li2006EvalHandler instance;

	public static void main(String[] args) throws IOException {

		Li2006EvalHandler p = new Li2006EvalHandler(Paths.MOMIEVALPATH_CSV);
		p.loadRows();
		System.out.println("adad");
	}

	private Li2006EvalHandler(String string) {

		this.path = string;
	}

	public static Li2006EvalHandler getInstance(String path) {

		if (instance == null)
			instance = new Li2006EvalHandler(path);
		return instance;
	}

	@Override
	public Double getSimilarity(int doc1, int doc2) throws IOException {
		if (docSims == null) {
			this.loadRows();
		}
		DocSim scores = docSims[doc1];
		if (scores != null)
			return scores.getSimilarityScore(doc2);
		else
			return null;
	}

	@Override
	protected int getDocCount() {

		return 60;
	}

	@Override
	protected int adjustID(int i) {
		return i;
	}
}
