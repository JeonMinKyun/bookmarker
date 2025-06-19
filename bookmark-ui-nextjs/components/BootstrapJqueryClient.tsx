'use client';

import { useEffect } from 'react';
import $ from 'jquery';

export default function BootstrapJQueryClient() {
	useEffect(() => {
	// jQuery를 글로벌로 등록 (Bootstrap JS에서 필요)
	(window as any).$ = $;
	(window as any).jQuery = $;

	// Bootstrap JS 로드
	import('bootstrap/dist/js/bootstrap.min.js').then(() => {
	    console.log('Bootstrap JS loaded');

	    // 모달 자동 띄우기 예시
	    // $('#myModal').modal('show');
	    });
	}, []);

	return null;
}